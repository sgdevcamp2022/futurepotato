import produce from 'immer';

export const initialMainState = {
    clearUpload : false,
    storyList:[],
    postList:[],
    limit:null,
    prePost:null,
    nextPost:null,
    newImage:[],
    isImage:false,
    detailPage:null,

}

const dummyData = {
    "storyList" : [{"name" : "user1", "profileImage" : "/cover 1.png"},
    {"name" : "user1", "profileImage" : "/cover 2.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"},
    {"name" : "user1", "profileImage" : "/cover 3.png"}],
    "postList" : [
        {id:1, name : "user1", "content": "게시글1","createdDate": "2023-01-01T12:11:00",
                "modifiedDate": "2023-01-01T13:11:00",
                likeCount: 12,
                likesCheck: true,
                "commentCount": 110,
                "profileImage" : '/cover 1.png',
                "commentList" : [{"commentWriter": "user2",
                "Image": "/cover 3.png",
                "comment": "게시글 댓글1",
                "likeCount": 100,
                
                "replyList":[{
                            "replyWriter": "user1", "reply":"reply1",
                            "createdDt":""
                        },
                        {
                            "replyWriter": "user2", "reply":"reply2",
                            "image":"dsfj.png",
                            "createdDt":""
                        },
                    ]}
                ],
                "imageList":[
                    {"image": "./cover 1.png"},
                    {"image": "./cover 2.png"},
                    {"image": "./cover 3.png"},
                    {"image": "./cover 4.png"},
                ],
                "isMultyImage" : false,
            }
    ],
    "limit" : 10,
    "prePost" : 0,
    "nextPost" : true,
}

const dummyPost = {
    id:3, 
    name : "yusung", 
    "content": "게시글4",
    "profileImage" : '/cover 8.png',
    "createdDate": "2023-01-01T12:11:00",
    "modifiedDate": "2023-01-01T13:11:00",
    likeCount: 0,
    likesCheck: false,
    "commentCount": 0,
    "commentList" : [],
    "imageList" : [{"image": "./cover 4.png"},
    {"image": "./cover 3.png"},{"image": "./cover 2.png"}],
    "isMultyImage" : false,
}

export const mainPageRequestAction = () => ({
    type: 'MAIN_PAGE_REQUEST',
  });

const reducer = (state = initialMainState, action) => produce(state, (draft) => {
    switch(action.type){
        case 'MAIN_PAGE_REQUEST' : 
            console.log("이게뭘까요?");
            break;
        case 'MAIN_PAGE_SUCCESS' :
            draft.storyList = draft.storyList.concat(dummyData.storyList);
            draft.postList = draft.postList.concat(dummyData.postList);//dummyData.postList;//draft.postList.concat(dummyData.postList);
            draft.limit = dummyData.limit;
            draft.prePost = dummyData.prePost;
            draft.nextPost = dummyData.nextPost;
            break;
        case 'MAIN_PAGE_FAIRLUE' :
            break;

        case 'POST_INFO_REQUEST':
            draft.detailPage = {
                
            }
            break;
        case 'POST_INFO_SUCCESS':
            draft.postList = action.data;
            break;
        case 'POST_INFO_FAILURE':
            break;
    
        case 'ADD_POST_REQUEST':
            break;
        case 'ADD_POST_SUCCESS':{
            draft.postList.unshift(dummyPost);
            draft.clearUpload = true;
            draft.newImage = [];
            break;
        }
        case 'ADD_POST_FAILURE':
            draft.clearUpload = true;
            draft.newImage = [];
            break;
    
        case 'MOD_POST_REQUEST':
            break;
        case 'MOD_POST_SUCCESS':{
            draft.postList.find((v) => v.name == action.dataId ? v.content = action.data : v.content);
            break;
        }
        case 'MOD_POST_FAILURE':
            break;
    
        case 'REMOVE_POST_REQUEST':
            break;
        case 'REMOVE_POST_SUCCESS':{
            console.log(action);
            draft.postList.filter((v) => v.id != action.data);
        }
            break;
        case 'REMOVE_POST_FAILURE':
            break;

        case 'ADD_COMMENT_REQUEST':
            {
                console.log(draft);
                const post = draft.postList.find((v) => v.id === action.dataw);
                console.log(post);
                post.commentList.push({"commentWriter" : action.datame.username, "Image" : action.datame.profileimage, 
                "comment" : action.data, "likeCount":0, "replyList" : []});
                break;
            }
        case 'ADD_COMMENT_SUCCESS':
            break;
        case 'ADD_COMMENT_FAILURE':
            break;
        
        case 'DELETE_COMMENT_REQUEST':
            break;
        case 'DELETE_COMMENT_SUCCESS':
            break;
        case 'DELETE_COMMENT_FAILURE':
            break;

        case 'IMAGE_UPLOAD_REQUEST':{
            console.log(action.data.name);
            draft.newImage.push(action.data.get("image").name);
            draft.isImage = true;
            break;
        }

        case 'ADD_REPLY_REQUEST':
            break;
        case 'ADD_REPLY_SUCCESS':
            break;
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
        default:
            break;

    }
});

export default reducer;