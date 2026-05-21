package com.roshanonjava.post8;

public class TextBlocks {

    static void main() {
        String html =
                "<html>\n" +
                        "    <body>\n" +
                        "        <h1>Hello, Java!</h1>\n" +
                        "    </body>\n" +
                        "</html>\n";

        String html1 = """
                <html>
                    <body>
                        <h1>Hello, Java!</h1>
                    </body>
                </html>
                """;

        IO.println(html);
        IO.println(html1);

        String json = """
                {
                    "id": 101,
                    "name": "Alice",
                    "active": true
                }
                """;
        IO.println(json);
    }
}
