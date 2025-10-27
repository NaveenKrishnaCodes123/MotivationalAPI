import com.nycschools.FakeSchoolRepository
import com.nycschools.domain.model.School
import com.nycschools.presentation.viewmodel.SchoolDetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SchoolDetailViewModelTest {

    private lateinit var repository: FakeSchoolRepository
    private lateinit var viewModel: SchoolDetailViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        repository = FakeSchoolRepository()
        repository.schoolDetail = School(
            dbn = "001",
            name = "ABC High",
            borough = "Manhattan",
            phone = "1234567890",
            satNumOfTakers = "100",
            satReading = "50",
            satMath = "45",
            satWriting = "55",
            overview = "Sample overview",
            website = "www.abchigh.edu",
            city = "New York",
            zip = "10001"
        )
        viewModel = SchoolDetailViewModel(repository, testDispatcher)
    }

    @Test
    fun load_sets_school_detail_correctly() = runTest {
        // When
        viewModel.load("001")

        // Advance dispatcher so coroutine completes
        testDispatcher.scheduler.advanceUntilIdle()

        // Then
        val state = viewModel.uiState.value
        assertEquals("ABC High", state?.name)
        assertEquals("Manhattan", state?.borough)
        assertEquals("100", state?.satNumOfTakers)
    }
}


