package edu.smartiezm.todo.data

import edu.smartiezm.todo.data.entity.Hotel
import edu.smartiezm.todo.data.repository.HotelRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(val hotelRepository: HotelRepository) :  CommandLineRunner{
    override fun run(vararg args: String?) {
        this.hotelRepository.deleteAll()

        val ibis = Hotel("Ibis", 3, 30)
        val decameron = Hotel("Decameron", 5, 50)
        val hilton = Hotel("Hilton", 5, 50)
        val caribe = Hotel("Caribe", 4, 40)
        val lasAmericas = Hotel(classification = 4, name = "Las Americas", nbRooms = 40)

        val hotels = listOf<Hotel>(ibis, decameron, hilton, caribe, lasAmericas)

        this.hotelRepository.saveAll(hotels)
        println("-- Database has been initialized")


    }
}