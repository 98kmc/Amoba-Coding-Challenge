package com.example.amobacodingchallenge.ui.patient_list_screen.patient_list_recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.databinding.PatientItemCellBinding
import com.example.amobacodingchallenge.domain.entities.Patient

class PatientListAdapter(
    private val patientList: MutableList<Patient>,
    private val onClickAction: ((Int) -> Unit)?
) : RecyclerView.Adapter<PatientListAdapter.PatientListViewHolder>() {

    inner class PatientListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = PatientItemCellBinding.bind(itemView)

        fun configure(patient: Patient) {
            binding.nameTextview.text = patient.name
            binding.actualPatientTextview.text = "Paciente actual"

            Glide.with(view)
                .load(patient.image.toString())
                .placeholder(R.drawable.user_icon)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.patientImageview)

            binding.patientItemCellContainer.setOnClickListener {
                onClickAction?.invoke(patient.id.toInt())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientListViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.patient_item_cell, parent, false)
        return PatientListViewHolder(view)
    }

    override fun getItemCount() = patientList.count()

    override fun onBindViewHolder(holder: PatientListViewHolder, position: Int) {
        holder.configure(patientList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newPatientList: List<Patient>){
        patientList.clear()
        patientList.addAll(newPatientList)
        notifyDataSetChanged()
    }
}