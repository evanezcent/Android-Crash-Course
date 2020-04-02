package id.kotlin.sa_mastering.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import id.kotlin.sa_mastering.R
import id.kotlin.sa_mastering.data.Result
import kotlinx.android.synthetic.main.home.*
import javax.inject.Inject

class HomeActivity: DaggerAppCompatActivity(), HomeViewModelCallback {

    @Inject
    lateinit var viewModel: HomeViewModel

    private lateinit var binding: HomeAdapterViewModel


    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
            this,
            R.layout.home)
            .apply { viewModel = this@HomeActivity.viewModel }
            .also { viewModel.getTheMovies() }
    }

    override fun onSuccess(res: List<Result>) {
//        binding.rv_home.addI
    }

    override fun onFailed(err: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}