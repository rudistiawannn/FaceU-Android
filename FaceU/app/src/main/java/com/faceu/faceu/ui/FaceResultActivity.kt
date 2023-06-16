package com.faceu.faceu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.faceu.faceu.R
import com.faceu.faceu.databinding.ActivityFaceResultBinding
import com.faceu.faceu.ui.vm.FaceViewModel
import java.io.File

class FaceResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaceResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityFaceResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFile = intent.getSerializableExtra(EXTRA_IMAGE) as File
        val label = intent.getStringExtra(EXTRA_LABEL)

        Glide.with(this)
            .load(mFile)
            .into(binding.ivResult)

        binding.btnCamera.setOnClickListener {
            startActivity(Intent(this, FaceCameraActivity::class.java))
        }

        binding.ivHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        when(label) {
            "Acne" -> {
                binding.tvFaceInfo.text = label
                binding.tvDescRes.setText(R.string.acne)
                binding.tvCausesRes.setText(R.string.acne_causes)
                binding.tvPreventRes.setText(R.string.acne_prevention)
                binding.tvRecRes.setText(R.string.acne_recommend)
                binding.tvTreatRes.setText(R.string.acne_treatment)
            }
            "Dark Spot" -> {
                binding.tvFaceInfo.text = label
                binding.tvDescRes.setText(R.string.dark_spot)
                binding.tvCausesRes.setText(R.string.dark_spot_causes)
                binding.tvPreventRes.setText(R.string.dark_spot_prevention)
                binding.tvRecRes.setText(R.string.dark_spot_recommend)
                binding.tvTreatRes.setText(R.string.dark_spot_treatment)
            }
            "Normal" -> {
                binding.tvFaceInfo.text = label
                binding.tvDescRes.setText(R.string.normal)
            }
            "Redness" -> {
                binding.tvFaceInfo.text = label
                binding.tvDescRes.setText(R.string.redness)
                binding.tvCausesRes.setText(R.string.redness_causes)
                binding.tvPreventRes.setText(R.string.redness_prevention)
                binding.tvRecRes.setText(R.string.redness_recommend)
                binding.tvTreatRes.setText(R.string.redness_treatment)
            }
            "Wrinkles" -> {
                binding.tvFaceInfo.text = label
                binding.tvDescRes.setText(R.string.wrinkle)
                binding.tvCausesRes.setText(R.string.wrinkles_causes)
                binding.tvPreventRes.setText(R.string.wrinkles_prevention)
                binding.tvRecRes.setText(R.string.wrinkles_recommend)
                binding.tvTreatRes.setText(R.string.wrinkles_treatment)
            }
            else -> {
                binding.tvFaceInfo.setText(R.string.unknown)
                binding.tvDescRes.setText(R.string.default_result)
            }
        }

    }
    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_LABEL = "extra_label"
    }
}