/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.WebService;
import edu.eci.arep.annotations.Web;

/**
 *
 * @author eduardo.ocampo
 */

public class WebService {
    
    @Web
    public static String hello(){
        return 
                "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Hello</h1>\n"
                + "</body>\n"
                + "</html>\n";
    }
    
}
