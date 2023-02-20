import produce from 'immer';

export const initialMainState = {
    clearUpload : false,
    storyList:[],
    storyListId:[],
    content:[],
    limit:null,
    prePost:null,
    nextPost:null,
    newImage:null,
    isImage:false,
    detailPage:null,
    alarmData:[],
    isStoryReady:false,
    last:null,
    pagingState:null,
    currentReqPost:null,
    isLoadingPost:false,
    profileLoad:false,
    isLikePost:false,
    isCommentLike:[],
}

export const mainPageRequestAction = () => ({
    type: 'MAIN_PAGE_REQUEST',
  });

const reducer = (state = initialMainState, action) => produce(state, (draft) => {
    switch(action.type){
        case 'MAIN_PAGE_REQUEST' : 
            break;
        case 'MAIN_PAGE_SUCCESS' :
            console.log(action.data);
            draft.content = draft.content.concat(action.data.content);
            draft.last = action.data.last;
            break;
        case 'MAIN_PAGE_FAIRLUE' :
            break;

        case 'POST_INFO_REQUEST':
            
            break;
        case 'POST_INFO_SUCCESS':
            draft.currentReqPost = action.data.data;
            draft.isLoadingPost = true;
            console.log("slslslslslsls");
            break;
        case 'POST_INFO_FAILURE':
            break;
    
        case 'ADD_POST_REQUEST':
            break;
        case 'ADD_POST_SUCCESS':{
            console.log("asdfasdfs");
            draft.content.unshift({'postId':2, 
            'accountId' : action.data.accountId, 
            "content": action.data.content,
            "createdDt": "방금전",
            'likeCount': 0,
            'likesCheck': false,
            "commentCount": 0,
            "profileImage" : '/cover 1.png',
            "commentList" : [
            ],
            "imageList":[
                    {"image": "./cover 11.png"},
                    {"image": "./cover 4.png"},
                    {"image": "./cover 5.png"},
                ],
            "multyimage" : true,
            });
            draft.clearUpload = true;
            break;
        }
        case 'ADD_POST_FAILURE':
            draft.clearUpload = true;
            draft.newImage = [];
            break;
    
        case 'MOD_POST_REQUEST':
            break;
        case 'MOD_POST_SUCCESS':{
            draft.content.find((v) => v.postId == action.dataId ? v.content = action.data : v.content);
            break;
        }
        case 'MOD_POST_FAILURE':
            break;
    
        case 'REMOVE_POST_REQUEST':
            console.log("포스트를 삭제합니다");
            break;
        case 'REMOVE_POST_SUCCESS':{
            console.log(action.data);
            const newPostList = draft.postList.filter((v) => v.id != action.data);
            draft.postList = newPostList;
            break;
        }
        case 'REMOVE_POST_FAILURE':
            break;

        case 'ADD_COMMENT_REQUEST':
            {   
                console.log(action.data.datame.username,action.data.datame.profileimage);
                draft.currentReqPost.commentList.push(
                {
                    "commentWriter":action.data.datame.username,
                    "profileImage": action.data.datame.profileimage,
                    "comment": action.data.content,
                    "likeCount": 0,
                    'commentId' : 2,
                    'createdDt' : "2023-02-10T12:18:57.614259",
                    "replyList":[
                    ]
                }
                );
                break;
            }
        case 'ADD_COMMENT_SUCCESS':
            break;
        case 'ADD_COMMENT_FAILURE':
            break;
        
        case 'DELETE_COMMENT_REQUEST':
            break;
        case 'DELETE_COMMENT_SUCCESS':{
            draft.currentReqPost.commentList.filter((v) => v.commentId != action.data.commentId);
            break;
        }
        case 'DELETE_COMMENT_FAILURE':
            break;

        case 'IMAGE_UPLOAD_REQUEST':{
            draft.newImage = action.data;
            draft.isImage = true;
            break;
        }

        case 'ADD_REPLY_REQUEST':
            break;
        case 'ADD_REPLY_SUCCESS':{
            console.log("ssssssss");
            const comment = draft.currentReqPost.commentList.findIndex((v) => v.commentId == action.data.commentId)
            draft.currentReqPost.commentList[comment].replyList.push({"replyWriter": action.data.nickname, "reply":action.data.reply,
            'image': action.data.profileImage,})
            break;
        }
        case 'ADD_REPLY_FAILURE':
            break;

        case 'DELETE_REPLY_REQUEST':
            break;
        case 'DELETE_REPLY_SUCCESS':
            break;
        case 'DELETE_REPLY_FAILURE':
            break;
        
        case 'LOAD_DETAIL_REQUEST':
            break;
        case 'LOAD_DETAIL_SUCCESS':
            break;
        case 'LOAD_DETAIL_FAILURE':
            break;

        case 'ALARM_REQUEST':
            break;
        case 'ALARM_REQUEST_SUCCESS':
            break;
        case 'ALARM_REQUEST_FAILURE':
            break;

        case 'STORY_REQUEST':
            break;
        case 'STORY_REQUEST_SUCCESS':
            draft.isStoryReady = true;
            break;
        case 'STORY_REQUEST_FAILURE':
            break;

        case 'LIKE_POST_REQUEST':
            break;
        case 'LIKE_POST_SUCCESS':
                break;
        case 'LIKE_POST_FAILURE':
            break;
        
        case 'LIKE_POST_CANCEL_REQUEST':
            break;
        case 'LIKE_POST_CANCEL_SUCCESS':
            break;
        case 'LIKE_POST_CANCEL_FAILURE':
            break;
        
        case 'LIKE_COMMENT_REQUEST':
            break;
        case 'LIKE_COMMENT_SUCCESS':
            break;
        case 'LIKE_COMMENT_FAILURE':
            break;

        case 'LIKE_COMMENT_CANCEL_REQUEST':
            break;
        case 'LIKE_COMMENT_CANCEL_SUCCESS':
            break;
        case 'LIKE_COMMENT_CANCEL_FAILURE':
            break;

        case 'IS_LIKE_REQUEST':
            break;
        case 'IS_LIKE_SUCCESS':
            draft.isLikePost = action.data;
            break;
        case 'IS_LIKE_FAILURE':
            break;

        case 'IS_LIKE_COMMENT_REQUEST':
            break;
        case 'IS_LIKE_COMMENT_SUCCESS':
            draft.isCommentLike.push(action.data);
            break;
        case 'IS_LIKE_COMMENT_FAILURE':
            break;

        case 'IS_LIKE_REPLY_REQUEST':
            break;
        case 'IS_LIKE_REPLY_SUCCESS':
            break;
        case 'IS_LIKE_REPLY_FAILURE':
            break;

        default:
            break;

    }
});

export default reducer;