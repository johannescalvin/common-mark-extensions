package tech.freecode.commonmark.ext;

import org.junit.Test;
import tech.freecode.commonmark.ext.url.accessibility.LinuxLocalFile;
import static org.junit.Assert.*;

public class LinuxLocalFileTest {
    @Test
    public void valid(){
        LinuxLocalFile localFile = new LinuxLocalFile();
        String path = localFile.getAbsolutePath("/home/xxxx/exmaple","../test.png");
        assertEquals("/home/xxxx/test.png",path);
    }

    @Test
    public void invalid(){
        LinuxLocalFile localFile = new LinuxLocalFile();
        String path = localFile.getAbsolutePath("/home/xxxx/exmaple","../../../../../");
        assertNull(path);
    }
}
