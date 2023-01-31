import produce from 'immer';

export const initialPostState = {
    "id": null,
    "name": null,
    "content": null,
    "createdDate": null,
    "modifiedDate": null,
    "likeCount":null,
    "likesCheck": false,
    "commentCount" : null,
    "commentList" : [],
    "imageList" : [],
    "isMultyImage" : false,
}

const reducer = (state = initialPostState, action) => produce(state, (draft) => {
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
            draft = action.data;
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

        
        default:
            return state;

    }
});

export default reducer;