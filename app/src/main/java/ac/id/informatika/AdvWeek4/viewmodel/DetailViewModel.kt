package ac.id.informatika.AdvWeek4.viewmodel

import ac.id.informatika.AdvWeek4.R
import ac.id.informatika.AdvWeek4.model.Student
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLD.value = student1
    }
}
