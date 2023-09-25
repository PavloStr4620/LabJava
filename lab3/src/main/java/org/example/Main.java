package org.example;

public class Main {
    public static void main(String[] args) {
        String text = "Ввести текст в якому поміж слів містяться електронні пошти 123@gmail.com. Знайти всі \n" +
                "електронні пошти в тексті, записати їх test@gmail.com у новий рядок через кому і пробіл. \n" +
                "Вивести отриманий рядок знайдених hello@gmail.com електронних пошт.";

        // Розділяємо текст на окремі слова за допомогою пропусків і розділових знаків
        String[] words = text.split("[\\s,;:]+");

        // Проходимо по кожному слову і перевіряємо, чи воно є email-адресою
        for (String word : words) {
            // Використовуємо метод endsWith() для перевірки, чи слово закінчується на "@" і має крапку
            if (word.endsWith("@") || word.contains("@") && word.indexOf("@") > 0 && word.indexOf("@") < word.length() - 1 && word.indexOf(".") > word.indexOf("@")) {
                System.out.println("Знайдено email: " + word);
            }
        }
    }
}