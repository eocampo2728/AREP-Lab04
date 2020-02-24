/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.webService;

import edu.eci.arep.annotations.Web;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * This class manage the different functionalities.
 * @author eduardo.ocampo
 */

public class WebService {

    /**
     * return a html to the user
     * @param resource is the direction of the resource
     * @param Output the one that receive the resource
     */
    @Web
    public static void html(String resource, OutputStream Output) {

        try {
            String text = "";
            String temp;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + resource));
            while ((temp = bufferedReader.readLine()) != null) {
                text = text + temp;
            }
            Output.write(("HTTP/1.1 201 Found  \r\n"
                    + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + text).getBytes());
        } catch (IOException e) {
        }
    }

    /**
     * return an jpg to the user
     *  @param resource is the direction of the resource
     *  @param Output the one that receive the resource
     */
    @Web
    public static void jpg(String resource, OutputStream Output) {

        try {
            BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + resource));
            ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
            DataOutputStream writeimg = new DataOutputStream(Output);
            ImageIO.write(image, "PNG", ArrBytes);
            writeimg.writeBytes("HTTP/1.1 200 OK \r\n");
            writeimg.writeBytes("Content-Type: image/png \r\n");
            writeimg.writeBytes("\r\n");
            writeimg.write(ArrBytes.toByteArray());
        } catch (IOException e) {
        }
    }

    /**
     * return a js to the user
     *  @param resource is the direction of the resource
     *  @param Output the one that receive the resource
     */
    @Web
    public static void js(String resource, OutputStream Output) {

        try {
            BufferedReader read = new BufferedReader(new FileReader(System.getProperty("user.dir") + resource));
            String cont = "";
            String line;
            while ((line = read.readLine()) != null) {
                cont = cont + line;
            }
            Output.write(("HTTP/1.1 404 Not Found \r\n"
                    + "Content-Type: application/json; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + cont).getBytes());
        } catch (IOException e) {
        }
    }
}
