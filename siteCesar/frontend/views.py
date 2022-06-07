from django.views.generic import TemplateView
from django.shortcuts import redirect, render

from frontend.forms import ReservaForm


def HomePageView(request):
    if request.method == 'POST':
        form = ReservaForm(request.POST)
        if form.is_valid(): 
            form.save()
            return redirect('/')
    else:
        form = ReservaForm()
        return render(request, 'index.html', {'form': form})