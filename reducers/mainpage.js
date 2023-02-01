import produce from 'immer';

export const initialMainState = {
    storyList:[{"name" : "user1", "profileImage" : "/cover 1.png"},
            {"name" : "user1", "profileImage" : "/cover 2.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"},
            {"name" : "user1", "profileImage" : "/cover 3.png"}],
    postList:[{id:1, name : "user1", "content": "게시글1","createdDate": "2023-01-01T12:11:00",
                "modifiedDate": "2023-01-01T13:11:00",
                likeCount: 12,
                likesCheck: true,
                "commentCount": 110,
                "commentList" : [{"commentWriter": "user2",
                "Image": "/cover 3.png",
                "comment": "게시글 댓글1",
                "likeCount": 100,}],
                "imageList":[
                    {"image": "./cover 1.png"},
                    {"image": "./cover 2.png"},
                    {"image": "./cover 3.png"},
                    {"image": "./cover 4.png"},
                ],
                "isMultyImage" : false,
            }],
    limit:null,
    prePost:null,
    nextPost:null,
    newImage:[ {"image": "./cover 1.png"},
    {"image": "./cover 2.png"},
    {"image": "./cover 3.png"},
    {"image": "./cover 4.png"},
    ],
    isImage:false,
}

export const mainPageRequestAction = () => ({
    type: 'MAIN_PAGE_REQUEST',
  });

const reducer = (state = initialMainState, action) => produce(state, (draft) => {
    switch(action.type){
        case 'MAIN_PAGE_REQUEST' : 
            break;
        case 'MAIN_PAGE_SUCCESS' :
            draft.storyList = draft.storyList.concat(action.data.storyList);
            draft.postList = draft.postList.concat(action.data.postList);
            break;
        case 'MAIN_PAGE_FAIRLUE' :
            break;

        case 'POST_INFO_REQUEST':
            break;
        case 'POST_INFO_SUCCESS':
            draft.postList = action.data;
            break;
        case 'POST_INFO_FAILURE':
            break;
    
        case 'ADD_POST_REQUEST':
            break;
        case 'ADD_POST_SUCCESS':
            break;
        case 'ADD_POST_FAILURE':
            break;
    
        case 'MOD_POST_REQUEST':
            break;
        case 'MOD_POST_SUCCESS':
            break;
        case 'MOD_POST_FAILURE':
            break;
    
        case 'REMOVE_POST_REQUEST':
            break;
        case 'REMOVE_POST_SUCCESS':
            break;
        case 'REMOVE_POST_FAILURE':
            break;

        case 'ADD_COMMENT_REQUEST':
            {
                const post = draft.postList.find((v) => v.id === action.dataw.id);
                post.commentList.push();
                break;
            }
        case 'IMAGE_UPLOAD_REQUEST':{
            console.log(action.data.name);
            draft.newImage.push(action.data.get("image").name);
            draft.isImage = true;
            break;
        }
        default:
            break;

    }
});

export default reducer;