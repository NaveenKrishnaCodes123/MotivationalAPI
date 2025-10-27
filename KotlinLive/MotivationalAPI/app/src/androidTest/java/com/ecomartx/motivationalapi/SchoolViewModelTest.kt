package com.ecomartx.motivationalapi

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SchoolViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var fakeRepository: FakeMotivationalRepository
    private lateinit var viewModel: MotivationalViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeMotivationalRepository()
        viewModel = MotivationalViewModel(fakeRepository)
    }

    @Test
    fun when_repository_returns_data_phrases_are_loaded() {
        val fakeList = listOf(
            MotivationalPhrase(1, "Stay strong", "Unknown", 1)
        )
        fakeRepository.phrases = fakeList

        viewModel.loadPhrases()
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(fakeList, viewModel.phrases.value)
        assertFalse(viewModel.isLoading.value)
        assertNull(viewModel.error.value)
    }


        @Test
        fun whenRepositoryReturnsData_phrasesAreLoaded() {
        fakeRepository.shouldThrow = true

        viewModel.loadPhrases()
        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModel.phrases.value.isEmpty())
        assertNotNull(viewModel.error.value)
    }
}

class FakeMotivationalRepository : MotivationalRepository() {
    var shouldThrow = false
    var phrases: List<MotivationalPhrase> = emptyList()

    override suspend fun getPhrases(): List<MotivationalPhrase> {
        if (shouldThrow) throw RuntimeException("Network error")
        return phrases
    }
}
