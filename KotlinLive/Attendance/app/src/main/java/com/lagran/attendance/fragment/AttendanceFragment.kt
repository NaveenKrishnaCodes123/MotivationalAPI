package com.mindcoin.dservicevp.fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.lagran.attendance.R
import com.lagran.attendance.activity.AttendanceReport


class AttendanceFragment : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_attendance, container, false)

        val homeToggle = view.findViewById<TextView>(R.id.homeToggle)
        val officeToggle = view.findViewById<TextView>(R.id.officeToggle)
        val attendance_report = view.findViewById<TextView>(R.id.attendance_report)

        fun activateHome() {
            homeToggle.setBackgroundResource(R.drawable.toggle_selected_left)
            officeToggle.setBackgroundResource(R.drawable.toggle_unselected_right)
            homeToggle.setTextColor(Color.WHITE)
            officeToggle.setTextColor(Color.BLACK)
        }

        fun activateOffice() {
            officeToggle.setBackgroundResource(R.drawable.toggle_selected_left)
            homeToggle.setBackgroundResource(R.drawable.toggle_unselected_right)
            officeToggle.setTextColor(Color.WHITE)
            homeToggle.setTextColor(Color.BLACK)
        }

        homeToggle.setOnClickListener { activateHome() }
        officeToggle.setOnClickListener { activateOffice() }

        attendance_report.setOnClickListener {
            val intent = Intent(requireContext(), AttendanceReport::class.java)
            startActivity(intent)
        }

        return view
    }


}