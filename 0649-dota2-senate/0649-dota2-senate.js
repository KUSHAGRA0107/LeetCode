/**
 * @param {string} senate
 * @return {string}
 */
var predictPartyVictory = function(senate) {
    let radiant = [];
    let dire = [];
    let n = senate.length;

    for(let i = 0; i < n; i++){
        if(senate[i] == 'R'){
            radiant.push(i);
        }else{
            dire.push(i);
        }
    }

    while(radiant.length > 0 && dire.length > 0){
        let rIndex = radiant.shift();
        let dIndex = dire.shift();
        if(rIndex < dIndex){
            radiant.push(rIndex + n);
        }else{
            dire.push(dIndex + n);
        }
    }
    return radiant.length > 0 ? "Radiant" : "Dire";
};