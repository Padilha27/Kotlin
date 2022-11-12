package com.example.application.repositories

import com.example.application.entities.Contact
import org.springframework.data.jpa.repository.JpaRepository

interface ContactRepository: JpaRepository<Contact, Long> {
}