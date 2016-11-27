package com.witcream.util;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.witcream.core.Consts;

public class ScanUtil {
	public static Set<Class<?>> scan(String packages) {
		Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
		boolean recursive = true;

		String packageName = packages;
		String packageDirName = packages.replace('.', '/');
		try {
			Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
			while (dirs.hasMoreElements()) {
				URL url = (URL) dirs.nextElement();
				String protocol = url.getProtocol();
				switch (protocol) {
				case "file":
					String filePath = URLDecoder.decode(url.getFile(), Consts.UTF_8.name());
					findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
					break;
				case "jar":
					JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
					Enumeration<JarEntry> entries = jar.entries();
					while (entries.hasMoreElements()) {
						JarEntry entry = (JarEntry) entries.nextElement();
						String name = entry.getName();
						if (name.charAt(0) == '/') {
							name = name.substring(1);
						}
						if (name.startsWith(packageDirName)) {
							int idx = name.lastIndexOf('/');
							if (idx != -1) {
								packageName = name.substring(0, idx).replace('/', '.');
							}
							if ((idx != -1) || (recursive)) {
								if ((name.endsWith(".class")) && (!entry.isDirectory())) {
									String className = name.substring(packageName.length() + 1, name.length() - 6);

									classes.add(Class.forName(packageName + '.' + className));
								}
							}
						}
					}
				}
			}
		} catch (Exception localException) {
		}
		return classes;
	}

	private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, boolean recursive,
			Set<Class<?>> classes) {
		File dir = new File(packagePath);
		if ((!dir.exists()) || (!dir.isDirectory())) {
			return;
		}
		File[] dirfiles = dir.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return (recursive && (file.isDirectory())) || (file.getName().endsWith(".class"));
			}
		});
		for (File file : dirfiles) {
			if (file.isDirectory()) {
				findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
						classes);
			} else {
				String className = file.getName().substring(0, file.getName().length() - 6);
				try {
					classes.add(
							Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
