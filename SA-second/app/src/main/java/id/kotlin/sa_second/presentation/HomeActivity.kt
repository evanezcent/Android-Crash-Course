package id.kotlin.sa_second.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import id.kotlin.sa_second.R
import id.kotlin.sa_second.data.Result
import id.kotlin.sa_second.databinding.HomeBinding
import javax.inject.Inject

class HomeActivity: DaggerAppCompatActivity(), HomeViewModelCallback {

    @Inject
    lateinit var viewModel:HomeViewModel

    private lateinit var binding: HomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<HomeBinding>(
            this,
            R.layout.home)
            .apply { viewModel = this@HomeActivity.viewModel }
            .also { viewModel.getMovies() }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDetach()
    }

    override fun onError(err: Throwable) {
        Log.e(HomeActivity::class.java.simpleName, "${err.printStackTrace()}")
    }

    override fun onSuccess(res: List<Result>) {
        binding.rvHome.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
        binding.rvHome.adapter = HomeAdapter(res)
    }
}