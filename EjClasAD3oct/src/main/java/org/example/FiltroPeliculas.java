package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FiltroPeliculas {

    public void filtrarPorAño(Integer año) {
        String inputFilePath = "peliculas.csv";
        String outputFilePath = "PeliculasPosterioresA" + año + ".csv";
        List<String> peliculasFiltradas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String header = br.readLine();
            peliculasFiltradas.add(header);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                int añoPelicula = Integer.parseInt(campos[2]);

                if (añoPelicula > año) {
                    peliculasFiltradas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String pelicula : peliculasFiltradas) {
                bw.write(pelicula);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo generado: " + outputFilePath);
    }
}
