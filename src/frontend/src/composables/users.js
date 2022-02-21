import { reactive, readonly, computed } from 'vue'

  const TOKEN = "access_token"
  const REFRESH = "refresh_token"

  const state = reactive({
    userData: {
      userName: "",
      firstName: "",
      lastName: "",
      email: "",
      roles: [],
    },
    isLoggedIn: false,
    loading: false,
    error: "",
  })

  const getters = {
      getFullName: () => {
        return computed(
          () => `${state.userData.firstName} ${state.userData.lastName}`
        )
      },
      getIsLoggedIn: () => {
        return computed(() => state.isLoggedIn)
      },
      getError: () => {
        return computed(() => state.error)
      },
      AuthGet: () => {
        return  {
          method: 'GET',
          headers: {
            'Authorization': 'Bearer ' + methods.getAccessToken(),
          },
        }
      },
      RefreshGet: () => {
        return  {
          method: 'GET',
          headers: {
            'Authorization': 'Bearer ' + methods.getRefreshToken(),
          },
        }
      }
    }

  const actions = {
    updateUserData: ({ first_name, last_name, email, username, roles }) => {
      state.userData.firstName = first_name
      state.userData.lastName = last_name
      state.userData.email = email
      state.userData.userName = username
      roles?.forEach(role => state.userData.roles.push(role))
  
      actions.updateIsLoggedIn(true);
    },
    updateIsLoggedIn: (isLoggedIn) => {
      state.isLoggedIn = isLoggedIn;
      if (isLoggedIn === false) {
        state.userData.firstName = ''
        state.userData.lastName = ''
        state.userData.email = ''
        state.userData.userName = ''
        state.userData.roles = []
        
        methods.removeTokens()
      }
    },
    updateLoading: (loadingStatus) => {
      state.loading = loadingStatus;
    },
    updateError: (error) => {
      state.error = error
    },
    updateAccessToken: (token) => {
      localStorage.setItem(TOKEN, token)
    },
    loadUser: async () => {
      const data = await methods.getUserData()
      if(data.status === 401 || data.status === 403) {
        actions.updateError("Attempting to refresh token")
        const response = await fetch('/api/token/refresh', getters.RefreshGet())
        const {access_token} = await response.json()
        actions.updateAccessToken(access_token)
        const newData = await methods.getUserData()
        if(newData.status === 200 || newData.status === 201) {
          actions.updateUserData(await newData.json())
        }
      } else if (data.status === 200 || data.status === 201) {
        actions.updateError('')
        actions.updateUserData( await data.json())
      } else {
        actions.updateError(data)
      }
    },
  }

  const methods = {
    getAccessToken: () => {
      if (localStorage.getItem(TOKEN) !== null) {
        return localStorage.getItem(TOKEN)
      }
    },
    getRefreshToken: () => {
      if (localStorage.getItem(REFRESH) !== null) {
        return localStorage.getItem(REFRESH)
      }
    },
    removeTokens: () => {
      localStorage.removeItem(TOKEN)
      localStorage.removeItem(REFRESH)
    },
    decodeJWT: (token) => {
      try {
        return JSON.parse(atob(token.split('.')[1]))
      } catch (e) {
        return null;
      }
    },
    getUserData: async () => {
      try {
        const {sub} = await methods.decodeJWT(methods.getAccessToken())
        return await fetch(`/api/user/${sub}`, getters.AuthGet())
      } catch(err) { 
        actions.updateError(err)
      }
    }
  }

  
  export default () => {
    return {
      state: readonly(state),
      ...getters,
      ...actions,
      ...methods,
    };
  };
