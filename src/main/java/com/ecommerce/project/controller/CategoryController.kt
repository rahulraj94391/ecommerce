package com.ecommerce.project.controller

import com.ecommerce.project.model.Category
import com.ecommerce.project.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController()
class CategoryController(
    @Autowired private val categoryService: CategoryService
) {
    @GetMapping("api/public/categories")
    fun getAllCategories(): List<Category> {
        return categoryService.allCategories
    }

    @PostMapping("api/public/categories")
    fun createCategory(@RequestBody category: Category): String {
        categoryService.createCategory(category)
        return "Category added successfully"
    }
}

