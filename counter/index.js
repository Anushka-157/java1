const counterValue =document.getElementById('counter-value');
const incrementBtn =document.getElementById('increment-btn');
const decrementBtn =document.getElementById('decrement-btn');
const resetBtn=document.querySelector('#reset');
let counter=0
incrementBtn.addEventListener('click',function(){
    counter++;
    counterValue.innerHTML=counter;
});
decrementBtn.addEventListener('click',function(){
    counter--;
    counterValue.innerHTML=counter;
});
resetBtn.addEventListener('click',function(){
    counter=0;
    counterValue.innerHTML=counter;
});
