from django import forms
from django.db.models import fields

from .models import Estacoes, Funcionarios, Reservas

class ReservaForm(forms.ModelForm):

    class Meta:
        model = Reservas
        fields = ('data', 'reserva_inicia_em', 'reserva_termina_em', 'id_estacao', 'id_funcionario')