import { tokenInsertHeader } from "../hooks/tokenInsertHeader";
import produce from 'immer'

export const initialState = {
    isLoggedIn:false,
    me:{profileimage: '/cover 8.png', username:'이유성', accountId:''},
    signUpData:{},
    loginData:{image: '/cover 1.png', username:'yusung'},
    loadProfileSuccess : false,
    profileData:{},
    folloingList:[],
    followerList:[],
    isFollowing:false,
    isSignupSuccess: false,
    isProfileLoading:false,
    searchVar:null,
}
const userdummyPage = {
    name:'user1',
    'profileImage' : '/cover 1.png',
    "followerCount": 100,
    "followingCount": 95,
    'postCount':1,
    'imageList':[
        {image:'/cover 1.png',
        postId:1,
        isMultyImage:true}
    ]
}
const dummyfolloingList = [
    {
    accountId: "user20",
    accountName:"박형우",
    profileImage:"../public/cover 9.png",
    },
    {
        accountId: "joa",
        accountName:"좋아아",
        profileImage:"./cover 10.png",
    },
    {
        accountId: "Atrox",
        accountName:"그랙",
        profileImage:"./cover 11.png",
    }
];

const dummyfollowerList = [
    {
    accountId: "user20",
    accountName:"박형우",
    profileImage:"./cover 9.png",
    },
    {
        accountId: "joa",
        accountName:"좋아아",
        profileImage:"./cover 10.png",
    },
    {
        accountId: "Atrox",
        accountName:"그랙",
        profileImage:"./cover 11.png",
    }
];

export const loginRequestAction = (data) => ({
    type: 'LOG_IN_REQUEST',
    data,
  });

export const signupRequestAction = (data) => ({
    type: 'SIGN_UP_REQUEST',
    data,
});

export const logoutRequestAction = () => ({
    type:'LOG_OUT',
})

//이전 상태를 액션을 통해 다음 상태로 만들어내는 함수(불면성은 지키고)
const reducer = (state = initialState, action) => produce(state, (draft) => {
        switch(action.type){
            case 'LOG_IN_REQUEST' :
                draft.me.accountId = action.data.accountId;
                draft.isLoggedIn = false;
                break;
            case 'LOG_IN_SUCCESS' :
                localStorage.setItem('token', action.data.token);
                tokenInsertHeader(action.data.token);
                draft.isLoggedIn = true;
                break;
            case 'LOG_IN_FAILURE' :
                draft.isLoggedIn = true;
                break;
    
            case 'SIGN_UP_REQUEST' :
                break;
            case 'SIGN_UP_SUCCESS' :
                draft.isSignupSuccess = true;
                break;
            case 'SIGN_UP_FAILURE' :
                break;
            
            case 'PROFILE_LOAD_REQUEST':
                draft.isProfileLoading = false;
                break;
            case 'PROFILE_LOAD_SUCCESS':
                {
                    console.log(action);
                    draft.profileData = action.data;
                    draft.isProfileLoading = true;
                    break;
                }
            case 'PROFILE_LOAD_FAILURE':
                break;
            
            case 'GET_FOLLOING_REQUEST':
                break;
            case 'GET_FOLLOING_SUCCESS':
                {
                    draft.folloingList = draft.folloingList.concat(dummyfolloingList);
                    
                    break;
                }
            case 'GET_FOLLOING_FAILURE':
                break;
                
            case 'GET_FOLLOWER_REQUEST':
                break;
            case 'GET_FOLLOWER_SUCCESS':
                {
                    draft.followerList = draft.followerList.concat(dummyfollowerList);
                    
                    break;
                }
            case 'GET_FOLLOWER_FAILURE':
                break;
            
            case 'FOLLOW_FOLLOW_REQUEST':
                console.log("asdfasdf");
                break;
            case 'FOLLOW_FOLLOW_SUCCESS':
                draft.isFollowing = true;
                break;
            case 'FOLLOW_FOLLOW_FAILURE':
                break;

            case 'FOLLOW_CANCEL_REQUEST':
                break;
            case 'FOLLOW_CANCEL_SUCCESS':
                draft.isFollowing = false;
                break;
            case 'FOLLOW_CANCEL_FAILURE':
                break;

            case 'GET_IS_FOLLOING_REQUEST':
                break;
            case 'GET_IS_FOLLOING_SUCCESS':
                console.log(action);
                draft.isFollowing = action.data;
                break;
            case 'GET_IS_FOLLOING_FAILURE':
                break;

            case 'PROFILE_IMAGE_REQUEST':
                break;
            case 'PROFILE_IMAGE_SUCCESS':
                break;
            case 'PROFILE_IMAGE_FAILURE':
                break;

            case 'PROFILE_EDIT_REQUEST':
                break;
            case 'PROFILE_EDIT_SUCCESS':
                draft.me.accountId = data.accountId;
                draft.me.username = data.accountName;
                break;
            case 'PROFILE_EDIT_FAILURE':
                break;

            case 'SEARCH_REQUEST':
                break;
            case 'SEARCH_REQUEST_SUCCESS':
                console.log(action.data);
                draft.searchVar = action.data;
                break;
            case 'SEARCH_REQUEST_FAILURE':
                break;

            case 'MY_PROFILE_REQUEST':
                break;
            case 'MY_PROFILE_SUCCESS':
                draft.me.profileimage = action.data.profileImage;
                draft.me.username = action.data.accountName;
                break;
            case 'MY_PROFILE_FAILURE':
                break;
            
            case 'LOG_OUT' :
                localStorage.clear();
                draft.isLoggedIn = false;
                break;
            default:
                break;
    
        }
});

export default reducer;