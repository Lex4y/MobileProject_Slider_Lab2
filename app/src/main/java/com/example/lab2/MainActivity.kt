package com.example.lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Объявление переменных для элементов интерфейса
    private lateinit var imageView: ImageView
    private lateinit var textViewDescription: TextView
    private lateinit var buttonPrevious: Button
    private lateinit var buttonNext: Button

    // Список изображений и их описаний
    private val images = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
    private val descriptions = listOf("Ледяные горы", "Пруд в лесу", "Горы на фоне заката")

    // Индекс текущего изображения
    private var currentImageIndex = 0

    // Метод, вызываемый при создании активности
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Установка макета активности
        setContentView(R.layout.activity_main)

        // Инициализация элементов интерфейса
        imageView = findViewById(R.id.imageView)
        textViewDescription = findViewById(R.id.textViewDescription)
        buttonPrevious = findViewById(R.id.buttonPrevious)
        buttonNext = findViewById(R.id.buttonNext)

        // Обработка изменений системных отступов
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Установка слушателя нажатий для кнопки "Предыдущее"
        buttonPrevious.setOnClickListener {
            // Обновление индекса текущего изображения и обновление отображаемого изображения и описания
            currentImageIndex = (currentImageIndex - 1 + images.size) % images.size
            updateImageAndDescription()
        }

        // Установка слушателя нажатий для кнопки "Следующее"
        buttonNext.setOnClickListener {
            // Обновление индекса текущего изображения и обновление отображаемого изображения и описания
            currentImageIndex = (currentImageIndex + 1) % images.size
            updateImageAndDescription()
        }
    }

    // Метод для обновления изображения и описания в зависимости от текущего индекса
    private fun updateImageAndDescription() {
        imageView.setImageResource(images[currentImageIndex])
        textViewDescription.text = descriptions[currentImageIndex]
    }
}
