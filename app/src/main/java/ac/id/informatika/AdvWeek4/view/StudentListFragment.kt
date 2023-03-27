package ac.id.informatika.AdvWeek4.view

import ac.id.informatika.AdvWeek4.R
import ac.id.informatika.AdvWeek4.viewmodel.ListViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class StudentListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val studentListAdapter = StudentListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

//        val recyclerViews: RecyclerView = findViewById(ac.id.informatika.AdvWeek4.R.id.txtError)

//        recListStudent.layoutManager = LinearLayoutManager(context)
//        recListStudent.adapter = studentListAdapter
        observeViewModel()

    }
    fun observeViewModel() {

        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            studentListAdapter.updateStudentList(it)
        })

        viewModel.studentLoadErrorLD.observe(viewLifecycleOwner, Observer {
//            val textView: TextView = findViewById(ac.id.informatika.AdvWeek4.R.id.txtError)
//            if(it == true) {
//                txtError.visibility = View.VISIBLE
//            } else {
//                txtError.visibility = View.GONE
//            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
//            if(it == true) {
//                R.id.recListStudent.visibility = View.GONE
//                progressBar.visibility = View.VISIBLE
//            } else {
//                recListStudent.visibility = View.VISIBLE
//                progressBar.visibility = View.GONE
//            }
        })
    }

}