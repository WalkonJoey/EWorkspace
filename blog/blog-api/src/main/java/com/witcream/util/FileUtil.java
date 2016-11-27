package com.witcream.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtil {
	public static File[] getFiles(String pattern) {
		return getFiles("./", pattern);
	}

	public static int findFileCount(File allList, String endName) {
		int textCount = 0;

		File[] fileArray = allList.listFiles();
		if (null == fileArray) {
			return 0;
		}
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isDirectory()) {
				textCount += findFileCount(fileArray[i].getAbsoluteFile(), endName);
			} else if (fileArray[i].isFile()) {
				if (fileArray[i].getName().endsWith(endName)) {
					textCount++;
				}
			}
		}
		return textCount;
	}

	public static File[] getFiles(String dir, String pattern) {
		File file = new File(dir);
		pattern = pattern.replace('.', '#');
		pattern = pattern.replaceAll("#", "\\\\.");
		pattern = pattern.replace('*', '#');
		pattern = pattern.replaceAll("#", ".*");
		pattern = pattern.replace('?', '#');
		pattern = pattern.replaceAll("#", ".?");
		pattern = "^" + pattern + "$";

		Pattern p = Pattern.compile(pattern);
		List<File> list = filePattern(file, p);

		File[] rtn = new File[list.size()];
		list.toArray(rtn);
		return rtn;
	}

	private static List<File> filePattern(File file, Pattern p) {
		if (file == null) {
			return null;
		}
		if (file.isFile()) {
			Matcher fMatcher = p.matcher(file.getName());
			if (fMatcher.matches()) {
				List<File> list = new ArrayList<File>();
				list.add(file);
				return list;
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			if ((files != null) && (files.length > 0)) {
				List<File> list = new ArrayList<File>();
				for (int i = 0; i < files.length; i++) {
					List<File> rlist = filePattern(files[i], p);
					if (rlist != null) {
						list.addAll(rlist);
					}
				}
				return list;
			}
		}
		return null;
	}
}
