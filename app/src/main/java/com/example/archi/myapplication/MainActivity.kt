package com.example.archi.myapplication


import android.content.Context
import android.graphics.SurfaceTexture
import android.hardware.Camera
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseIntArray
import android.view.Surface
import android.view.TextureView
import android.widget.Button
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.ml.vision.FirebaseVision

class MainActivity : AppCompatActivity(),TextureView.SurfaceTextureListener {

    private var cameradevice:CameraDevice?=null
    private val ORIENTATIONS = SparseIntArray()

    init {
        ORIENTATIONS.append(Surface.ROTATION_0, 90)
        ORIENTATIONS.append(Surface.ROTATION_90, 0)
        ORIENTATIONS.append(Surface.ROTATION_180, 270)
        ORIENTATIONS.append(Surface.ROTATION_270, 180)
    }

    private var mtextureview: TextureView?=null
    private var mCamera : Camera?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn);
        val textureview = findViewById<TextureView>(R.id.textureview);
        btn.setOnClickListener {
            getPicture()
        }
        val detector = FirebaseVision.getInstance()
                .getVisionFaceDetector()

        val result = detector.detectInImage()
                .addOnSuccessListener { faces ->
                    // Task completed successfully
                    // ...
                }
                .addOnFailureListener(
                        object : OnFailureListener {
                            override fun onFailure(e: Exception) {
                                // Task failed with an exception
                                // ...
                            }
                        })
    }

    private fun getPicture() {
        if(cameradevice==null)
        {
            return
        }
        var manager:CameraManager= getSystemService(Context.CAMERA_SERVICE) as CameraManager

        var characteristics:CameraCharacteristics=manager.getCameraCharacteristics(cameradevice!!.id)

    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
