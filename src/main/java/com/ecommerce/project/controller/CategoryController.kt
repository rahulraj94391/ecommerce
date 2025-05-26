package com.ecommerce.project.controller

import com.ecommerce.project.model.Category
import com.ecommerce.project.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController()
@RequestMapping("/api")
class CategoryController(
    @Autowired private val categoryService: CategoryService
) {
    @GetMapping("/public/categories")
    fun getAllCategories(): List<Category> {
        return categoryService.allCategories
    }

    @PostMapping("/public/categories")
    fun createCategory(@RequestBody category: Category): String {
        categoryService.createCategory(category)
        return "Category added successfully"
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    fun deleteCategory(@PathVariable categoryId: Long): ResponseEntity<String> {
        return try {
            val deleteStatus = categoryService.deleteCategory(categoryId)
            ResponseEntity(deleteStatus, HttpStatus.OK)
        } catch (e: ResponseStatusException) {
            ResponseEntity(e.reason, e.statusCode)
        }
    }

}

