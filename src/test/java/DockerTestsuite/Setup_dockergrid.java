package DockerTestsuite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Setup_dockergrid {


    @BeforeTest
    public void startdockergrid() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start Start_dockergrid.bat");
        Thread.sleep(70000);
    }



    @AfterTest
    public void stopdockergrid() throws IOException, InterruptedException {

        Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
        Thread.sleep(6000);
        Runtime.getRuntime().exec("taskkill /f /im cmd.exe");

    }




}
