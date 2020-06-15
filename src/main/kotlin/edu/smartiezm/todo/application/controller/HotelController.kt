package edu.smartiezm.todo.application.controller

import edu.smartiezm.todo.application.request.CheckInRequest
import edu.smartiezm.todo.data.entity.Hotel
import edu.smartiezm.todo.data.repository.HotelRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController(val hotelRepository: HotelRepository) {

    @GetMapping("")
    fun allHotels(): MutableIterable<Hotel> =
        this.hotelRepository.findAll()

    @GetMapping("/{name}")
    fun findByName(@PathVariable("name") name: String): List<Hotel> =
        this.hotelRepository.findByName(name)

    @PostMapping("/check_in")
    fun checkIn(@RequestBody checkInRequest: CheckInRequest) {
        val hotel = this.hotelRepository.findByName(checkInRequest.hotelName)[0]
        hotel.checkIn(checkInRequest.nbGuest)
        this.hotelRepository.save(hotel)
    }
}