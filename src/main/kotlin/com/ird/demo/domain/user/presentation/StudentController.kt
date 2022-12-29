package com.ird.demo.domain.user.presentation

import com.ird.demo.domain.user.presentation.data.response.StudentResponseDto
import com.ird.demo.domain.user.service.AddStudentService
import com.ird.demo.domain.user.service.DeleteStudentService
import com.ird.demo.domain.user.service.GetStudentListService
import com.ird.demo.domain.user.util.StudentConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController(
    private val studentConverter: StudentConverter,
    private val addStudentService: AddStudentService,
    private val getStudentListService: GetStudentListService,
    private val deleteStudentService: DeleteStudentService
) {

    @PostMapping
    fun addStudent(): ResponseEntity<Void> {
        addStudentService.execute()
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun getStudentList(): ResponseEntity<List<StudentResponseDto>> {
        return ResponseEntity.ok(getStudentListService.execute())
    }

    @DeleteMapping("/{studentId}")
    fun deleteStudent(@PathVariable("studentId") studentId: Long): ResponseEntity<Void> =
        studentConverter.toDto(studentId)
            .let { deleteStudentService.execute(it) }
            .let { ResponseEntity.ok().build() }
}