package renderer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Shader {

    private int shaderProgramID;
    private String vertexSource;
    private String fragmentSource;
    private String filepath;

    public Shader(String filepath){
        this.filepath=filepath;
        try{
            String source = new String(Files.readAllBytes(Paths.get(filepath)));
            String[] splitString = source.split("(#type)( )+([a-zA-Z]+)");

            //finds first pattern after #type pattern
            int index = source.indexOf("#type") + 6;
            int eol = source.indexOf("\n",index);
            String firstPattern = source.substring(index, eol).trim();

            //find second pattern after #type
            index = source.indexOf("#type", eol) + 6 ;
            eol = source.indexOf("\n",index);
            String secondPattern = source.substring(index, eol).trim();

            if(firstPattern.equals("vertex")){
                vertexSource = splitString[1];
            } else if (firstPattern.equals("fragment")){
                fragmentSource = splitString[1];
            } else {
                throw new IOException("Unexpected token " +firstPattern);
            }
            if(secondPattern.equals("vertex")){
                vertexSource = splitString[1];
            } else if (secondPattern.equals("fragment")){
                fragmentSource = splitString[1];
            } else {
                throw new IOException("Unexpected token " +secondPattern);
            }
        } catch (IOException e){
            e.printStackTrace();
            assert false : "Error : could not open file for shader";
        }
        System.out.println(vertexSource);
        System.out.println(fragmentSource);

    }

    public void compile(){

    }

    public void use(){

    }

    public void detach(){

    }
}
