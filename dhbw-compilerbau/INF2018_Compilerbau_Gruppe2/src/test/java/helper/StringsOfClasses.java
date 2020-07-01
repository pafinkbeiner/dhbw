
package helper;

import java.io.InputStream;

public class StringsOfClasses
{
    public String readJavaClass(String path)
    {
        String result;
        try
        {
            InputStream filestream = this.getClass()
                    .getResourceAsStream(path);
            result = new String(filestream.readAllBytes());
        }
        catch ( Exception e )
        {
            result = "";
        }

        return result;
    }
}
