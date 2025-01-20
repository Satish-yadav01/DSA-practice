package com.ratelimiter.loggingfilter.config;



import jakarta.servlet.WriteListener;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CachedBodyHttpServletResponse extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final ServletOutputStream servletOutputStream = new CachedServletOutputStream(byteArrayOutputStream);
    private final PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);

    public CachedBodyHttpServletResponse(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return servletOutputStream;
    }

    @Override
    public PrintWriter getWriter() {
        return printWriter;
    }

    @Override
    public void flushBuffer() {
        try {
            printWriter.flush();
            servletOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getBody() {
        flushBuffer();
        return byteArrayOutputStream.toByteArray();
    }
}

class CachedServletOutputStream extends ServletOutputStream {
    private final ByteArrayOutputStream byteArrayOutputStream;

    public CachedServletOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
        this.byteArrayOutputStream = byteArrayOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        byteArrayOutputStream.write(b);
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        // Not implemented
    }
}
