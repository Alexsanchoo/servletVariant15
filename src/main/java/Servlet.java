import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");/* Устанавливает тип контента ответа, отправляемого клиенту, если ответ еще не фиксировался.*/
        request.setCharacterEncoding("UTF-8"); /* Устанавливает кодировку символов (набор символов MIME) ответа, отправляемого клиенту, например, UTF-8.*/
        PrintWriter out = response.getWriter();/*Возвращает в PrintWriter объект, который может отправить символьный текст клиенту.*/
        String arrStr = request.getParameter("Arr");
        String choiceStr = request.getParameter("Choice");


        boolean isGood = true;
        String[] values;
        int[] arr = null;
        String result = "Error! Please, try again.";
        try
        {
            values = arrStr.split(" ");
            arr = new int[values.length];
            for(int i = 0; i < values.length; i++) {
                arr[i] = Integer.parseInt(values[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
            isGood = false;
        }


        if(isGood && choiceStr.length() == 1) {
            switch (choiceStr.charAt(0)) {
                case '1':
                {
                    int nk = 1;
                    for (int i = 0; i < arr.length; i++) {
                        nk = lcm(nk, arr[i]);
                    }
                    result = "Smallest common multiple: " + String.valueOf(nk);
                }
                    break;

                case '2':
                {
                    int nd = arr[0];
                    for (int i = 1; i < arr.length; i++) {
                        nd = gcd((nd<arr[i]?nd:arr[i]),(nd<arr[i]?arr[i]:nd));
                    }
                    result = "Greatest common divisor: " + String.valueOf(nd);
                }
                    break;

                case '3':
                {
                    int min = arr[0];
                    for (int i = 1; i < arr.length; i++) {
                        if(arr[i] < min) {
                            min = arr[i];
                        }
                    }
                    result = "Min value: " + String.valueOf(min);
                }
                    break;

                case '4':
                {
                    int max = arr[0];
                    for (int i = 1; i < arr.length; i++) {
                        if(arr[i] > max) {
                            max = arr[i];
                        }
                    }
                    result = "Max value: " + String.valueOf(max);
                }
                    break;

                case '5':
                {
                    double avg = 0.0;
                    int sum = 0;
                    for (int i = 0; i < arr.length; i++) {
                        sum += arr[i];
                    }
                    avg = (double) sum / arr.length;
                    result = "Avg value: " + String.valueOf(avg);
                }
                    break;

                default:
                    break;
            }
        }


        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Text Redactor Server</title>");
            out.println("</head>");
            out.println("<h1 align='center'><font face = 'Calibri'><b>The result:</b></font><br></h1>");
            out.println("<body>");
            out.println("<center>" + result +"</center><br></br>");
            out.println("<a href = \"http://localhost:8080\">Click here to see main page</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }


    public static int gcd(int a,int b){     //нод
        return b == 0 ? a : gcd(b,a % b);
    }

    public static int lcm(int a,int b) { //нок
        return a / gcd(a, b) * b;
    }
}



