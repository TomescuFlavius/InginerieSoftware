<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="Cars">
    <h1>Cars</h1>
    <div class="containe text-center">
        <div class="row">
            <div class="col">
                BMW
            </div>
            <div class="col">
                Spot 1
            </div>
            <div class="col">
                Alex
            </div>
        </div>
        <div class="row">
            <div class="col">
                Audi
            </div>
            <div class ="col">
                Spot 2
            </div>
            <div class ="col">
                Andrei
            </div>
        </div>
        <div class ="row">
            <div class ="col">
                Mercedes
            </div>
            <div class="col">
                Spot 3
            </div>
            <div class="col">
                Denis
            </div>
        </div>
    </div>
    <h5>Free parking spots: ${numberOfFreeParkingSpots}</h5>
</t:pageTemplate>
