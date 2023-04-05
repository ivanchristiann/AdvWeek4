package ac.id.informatika.AdvWeek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ac.id.informatika.AdvWeek4.R
import ac.id.informatika.AdvWeek4.util.loadImage
import ac.id.informatika.AdvWeek4.viewmodel.DetailViewModel
import ac.id.informatika.AdvWeek4.viewmodel.ListViewModel
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }
    fun observeViewModel(){
        //t
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).idStudent)
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            val progressBarDetail = view?.findViewById<ProgressBar>(R.id.progressBarDetailFoto)
            val photoImage = view?.findViewById<ImageView>(R.id.imageView3)
            val txtId = view?.findViewById<TextInputEditText>(R.id.txtID)
            val txtName = view?.findViewById<TextInputEditText>(R.id.txtName)
            val txtBodate = view?.findViewById<TextInputEditText>(R.id.txtBodate)
            val txtPhone = view?.findViewById<TextInputEditText>(R.id.txtPhone)

            if (progressBarDetail != null) {
                photoImage?.loadImage(viewModel.studentsLD.value?.photoUrl, progressBarDetail)
            }
            txtId?.setText(viewModel.studentsLD.value?.id)
            txtName?.setText(viewModel.studentsLD.value?.name)
            txtBodate?.setText(viewModel.studentsLD.value?.dob)
            txtPhone?.setText(viewModel.studentsLD.value?.phone)
        })
    }
}