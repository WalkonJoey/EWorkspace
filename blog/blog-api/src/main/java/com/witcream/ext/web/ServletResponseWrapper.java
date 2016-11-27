package com.witcream.ext.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ServletResponseWrapper
  extends HttpServletResponseWrapper
{
  private ByteArrayOutputStream buffer;
  
  public ServletResponseWrapper(HttpServletResponse response)
  {
    super(response);
    this.buffer = new ByteArrayOutputStream();
  }
  
  public ServletOutputStream getOutputStream()
    throws IOException
  {
    return new ServletOutputStreamWrapper(this.buffer);
  }
  
  public PrintWriter getWriter()
    throws IOException
  {
    return new PrintWriter(this.buffer);
  }
  
  public ByteArrayOutputStream getBuffer()
  {
    return this.buffer;
  }
  
  private class ServletOutputStreamWrapper
    extends ServletOutputStream
  {
    private ByteArrayOutputStream buffer;
    
    public ServletOutputStreamWrapper(ByteArrayOutputStream buffer)
    {
      this.buffer = buffer;
    }
    
    public boolean isReady()
    {
      return false;
    }
    
    public void setWriteListener(WriteListener listener) {}
    
    public void write(int b)
      throws IOException
    {
      this.buffer.write(b);
    }
  }
}
