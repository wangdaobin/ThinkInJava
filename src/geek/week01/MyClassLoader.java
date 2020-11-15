package geek.week01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description : 自定义类加载器
 * @Author : WDB
 * @Date: 2020-10-20 20:44
 */
public class MyClassLoader extends ClassLoader{
    private String path;

    public MyClassLoader(String path){
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = null;
        byte[] bytes = getBytes(path);
        if (bytes != null) {
            // 将class的字节码数组转换成Class类的实例
            result = defineClass(name, bytes, 0, bytes.length);
        }
        return result;
    }

    /**
     * 获取指定文件名称字节码（指定目录下）
     * @param path 文件路径
     * @return 文件字节数组
     */
    private byte[] getBytes(String path){
        File file = new File(path);
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        String path = "E:\\Geek\\Hello.class";
        MyClassLoader myClassLoader = new MyClassLoader(path);
        try {
            Class<?> hello = myClassLoader.loadClass("geek.week01.Hello");
            //System.out.println("类加载器是:" + hello.getClassLoader());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
