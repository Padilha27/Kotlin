package com.example.application.controllers

import com.example.application.entities.Contact
import com.example.application.repositories.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/contacts")
class ContactController {
    @Autowired
    lateinit var repository: ContactRepository

    @GetMapping
    fun index(): List<Contact> {
        return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody contact: Contact): Contact {
        return repository.save(contact)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody newContact: Contact): Contact {
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException()}

        contact.apply {  }
    }
}