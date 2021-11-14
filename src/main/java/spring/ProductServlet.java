package spring.demo.spring;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet(name = "ProductServlet", urlPatterns = {"/prod"})
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String amountOfProducts = req.getParameter("amount");



        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        final int amountInt = Integer.parseInt(amountOfProducts);

        resp.getWriter().write("<h2> Корзина </h2>");


        List<Product> productList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < amountInt; i++) {
            productList.add(new Product(i, "продукт" + i, 10 * i ));
        }

        resp.getWriter().println(productList);

    }
}


