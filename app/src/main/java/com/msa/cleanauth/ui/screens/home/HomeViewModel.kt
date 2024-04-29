package com.msa.cleanauth.ui.screens.home

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    val isLoading = mutableStateOf(false)
    private val _userData = MutableStateFlow<List<UserModel>>(emptyList())
    val userData = _userData.asStateFlow()

    //Detail Screen variable
    var user by mutableStateOf<User?>(null)
        private set

//    init {
//        getAllUser()
//    }

    fun getAllUser() = viewModelScope.launch {
        isLoading.value = true
        val fetchUserListEntity = repository.getAllUser()
        _userData.value = listOf(fetchUserListEntity)
    }.invokeOnCompletion {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            isLoading.value = false
        }, 3000)
    }

    fun addUser(newUser: User) {
        user = newUser
    }
}