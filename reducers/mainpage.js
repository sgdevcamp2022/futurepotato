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
    
    "content" : [
        {'postId':1, 
        'accountId' : "user1", 
        "content": "게시글1",
        "createdDt": "2023-01-01T12:11:00",   
        "modifiedDt": "2023-01-01T13:11:00",
        'likeCount': 12,
        'likesCheck': true,
        "commentCount": 110,
        "profileImage" : '/cover 1.png',
        "commentList" : [
            {
                "commentWriter": "user2",
                "profileImage": "/cover 3.png",
                "comment": "게시글 댓글1",
                "likeCount": 100,
                'commentId' : 1,
                'replyCount' : 2,
                'createdDt' : "2023-02-10T12:18:57.614259",
                "replyList":[
                    {
                        'replyId':3,
                        "replyWriter": "user1", "reply":"reply1",
                        'profileImage': '/cover 8.png',
                        "createdDt":""
                    },
                    {
                        'replyId':1,
                        "replyWriter": "user2", "reply":"reply2",
                        "profileImage":'/cover 8.png',
                        "createdDt":""
                    },
                ]
            }
        ],
        "imageList":[
                {"image": "./cover 1.png"},
                {"image": "./cover 2.png"},
                {"image": "./cover 3.png"},
                {"image": "./cover 4.png"},
            ],
        "multyimage" : false,
        }
    ],

    "last":false,
    "pagingState" : "Page request [number: 0, size 2, sort: UNSORTED]",

}

const dummyPostRe = {
    'postId':1, 
        'accountId' : "user1", 
        "content": "게시글1",
        "createdDt": "2023-01-01T12:11:00",   
        "modifiedDt": "2023-01-01T13:11:00",
        'likeCount': 12,
        'likesCheck': true,
        "commentCount": 110,
        "profileImage" : '/cover 1.png',
        "commentList" : [
            {
                "commentWriter": "user2",
                "profileImage": "/cover 3.png",
                "comment": "게시글 댓글1",
                "likeCount": 100,
                'commentId' : 1,
                'replyCount' : 2,
                'createdDt' : "2023-02-10T12:18:57.614259",
                "replyList":[
                    {
                        'replyId':3,
                        "replyWriter": "user1", "reply":"reply1",
                        'profileImage': '/cover 8.png',
                        "createdDt":""
                    },
                    {
                        'replyId':1,
                        "replyWriter": "user2", "reply":"reply2",
                        "profileImage":'/cover 8.png',
                        "createdDt":""
                    },
                ]
            }
        ],
        "imageList":[
                {"image": "./cover 1.png"},
                {"image": "./cover 2.png"},
                {"image": "./cover 3.png"},
                {"image": "./cover 4.png"},
            ],
        "multyimage" : false,
        
}

const dummyStory = {
    accountId:'유우우성',
    "profileImage": "../public/cover 5.png",
    "storyList": [
        {
            "storyId": 24,
            "storedStoryImage": "../public/cover 6.png",
            "createdDt": "2023-02-10T11:43:59.193341"
        },
        {
            "storyId": 25,
            "storedStoryImage": "../public/cover 7.png",
            "createdDt": "2023-02-10T11:45:24.080901"
        }
    ]
}

const dummyAlarm = [
    {
        "id": 9,
        "sender": "user5",
        "receiver": "user6",
        "place": "user6's post",
        "action": "댓글을 달았습니다.",
        "actionMessage": "user5님이 user6's post에 댓글을 달았습니다."
    },
    {
        "id": 10,
        "sender": "user8",
        "receiver": "user6",
        "place": "user6's post",
        "action": "댓글을 달았습니다.",
        "actionMessage": "user8님이 user6's post에 댓글을 달았습니다."
    },
    {
        "id": 12,
        "sender": "user7",
        "receiver": "user6",
        "place": " ccmet",
        "action": "대댓글을 달았습니다.",
        "actionMessage": "user7님이  ccmet에 대댓글을 달았습니다."
    } 
]

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
            draft.content = draft.content.concat(dummyData.content);//dummyData.postList;//draft.postList.concat(dummyData.postList);
            draft.limit = dummyData.limit;
            draft.last = dummyData.last;
            draft.pagingState = dummyData.pagingState;
            break;
        case 'MAIN_PAGE_FAIRLUE' :
            break;

        case 'POST_INFO_REQUEST':
            
            break;
        case 'POST_INFO_SUCCESS':
            draft.currentReqPost = dummyPostRe;
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
            draft.alarmData = dummyAlarm;
            break;
        case 'ALARM_REQUEST_FAILURE':
            break;

        case 'STORY_REQUEST':
            break;
        case 'STORY_REQUEST_SUCCESS':
            draft.storyListId = dummyStory;
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

        default:
            break;

    }
});

export default reducer;