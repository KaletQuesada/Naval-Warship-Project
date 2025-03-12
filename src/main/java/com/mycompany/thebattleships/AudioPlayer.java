/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thebattleships;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author nilo
 */

public class AudioPlayer{
    private MediaPlayer mediaPlayer;

    public AudioPlayer(String audioPath, int type) {
        // Crear objeto Media con la ruta del archivo
        Media media = new Media(audioPath);

        // Crear el MediaPlayer para reproducir el archivo
        mediaPlayer = new MediaPlayer(media);

        // Configurar el MediaPlayer para que se repita indefinidamente si se decea
        if (type == 1) {
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        }

    }

    // Reproducción en bucle
    public void PlayOnBucle() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    // Reproducción normal
    public void Play() {
        new Thread(() -> mediaPlayer.play()).start();
    }

    // Detener la reproducción
    public void Stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    // Ajustar el volumen
    public void setVolumen(double volumen) {
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volumen);
        }
    }
}
    