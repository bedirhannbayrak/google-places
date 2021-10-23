export const initialValue = {
  latitude:  "",
  longitude: "",
  radius: ""
};


const reducer = (state, action) => {
  switch (action.type) {
    case 'update':
      return {
        ...state,
        [action.payload.key]: action.payload.value,
      };
    default:
      throw new Error(`Unknown action type: ${action.type}`);
  }
};

export default reducer