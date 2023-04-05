package ac.id.informatika.AdvWeek4.view

import ac.id.informatika.AdvWeek4.R
import ac.id.informatika.AdvWeek4.model.Student
import ac.id.informatika.AdvWeek4.util.loadImage
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class StudentListAdapter(val studenList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtID).text = studenList[position].id
        holder.view.findViewById<TextView>(R.id.txtName).text = studenList[position].name
        holder.view.findViewById<TextView>(R.id.btnDetail).setOnClickListener{
            val action = StudentListFragmentDirections.actionStudentDetail(studenList[position].id.toString())
            Navigation.findNavController(it).navigate(action)
        }

        var imageView = holder.view.findViewById<ImageView>(R.id.imageViewPhoto)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBarStudentPhoto)
        imageView.loadImage(studenList[position].photoUrl, progressBar)
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}
