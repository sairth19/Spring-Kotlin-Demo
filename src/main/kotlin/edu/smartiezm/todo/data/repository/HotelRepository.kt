package edu.smartiezm.todo.data.repository

import edu.smartiezm.todo.data.entity.Hotel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : CrudRepository<Hotel, Long>{
    fun findByName(name: String): List<Hotel>
}