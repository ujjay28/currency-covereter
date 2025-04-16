package com.currency.converter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CurrencyConverterServlet")
public class CurrencyConverterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double amount = Double.parseDouble(request.getParameter("amount"));
        String conversionType = request.getParameter("conversionType");

        double result = 0;

        if (null != conversionType) switch (conversionType) {
            case "USDToINR":
                result = amount * 83.2; // Example rate
                break;
            case "INRToUSD":
                result = amount / 83.2;
                break;
        }

        request.setAttribute("originalAmount", amount);
        request.setAttribute("convertedAmount", result);
        request.setAttribute("conversionType", conversionType);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
